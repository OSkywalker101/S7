**Multicore Architecture and Programming Programs**

Program 1: Implement parallel processing to calculate the sum of an array.

Program 2: Implement parallel processing for Basic Multi-Core Matrix Addition

Program 3: Implement Parallel Search in an Array

Program 4: Implement multi-threading to simulate concurrent bank transactions.

Program 5: Implement Parallel Sorting with Merge Sort

Program 6: Implement a producer-consumer model using threads for task management.

Program 7: Implement condition variables to manage thread communication in production scenarios.

Program 8: Implement Parallel array Summation using OpenMP for performance optimization

Program 9: Implement task parallelism in image processing applications using OpenMP.

Program 10: Implement timeout mechanisms to handle deadlocks effectively

Program 11: Implement a work-stealing scheduler to optimize task processing among threads.

**Program 1: Implement parallel processing to calculate the sum of an array.**

#include <stdio.h>

#include <pthread.h>

// Shared array and variables to store partial sums

int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

int sum1 = 0;

int sum2 = 0;

// Thread 1 function: sums the first half (indices 0 to 3)

void\* sum\_first\_half(void\* arg) {

for (int i = 0; i < 4; i++) {

sum1 += arr[i];

}

return NULL;

}

// Thread 2 function: sums the second half (indices 4 to 7)

void\* sum\_second\_half(void\* arg) {

for (int i = 4; i < 8; i++) {

sum2 += arr[i];

}

return NULL;

}

int main() {

pthread\_t t1, t2;

// Create two threads

pthread\_create(&t1, NULL, sum\_first\_half, NULL);

pthread\_create(&t2, NULL, sum\_second\_half, NULL);

// Wait for both threads to finish

pthread\_join(t1, NULL);

pthread\_join(t2, NULL);

// Combine results

int total\_sum = sum1 + sum2;

printf("Total Sum: %d\n", total\_sum);

return 0;

}

**Commands**

1. Check number of CPUs

nproc

2. Get detailed CPU information

lscpu

3. Compile pthread program

gcc sum.c -o sum -pthread

4. Execute

./sum

5. Monitor CPU usage

top

6. Show individual CPU/core usage

top

Then press 1

7. View threads

ps -eLf

8. Run using only CPU 0

taskset -c 0 ./sum

9. Run normally on available CPUs

./sum

**Program 2: Implement parallel processing for Basic Multi-Core Matrix Addition**

#include <stdio.h>

#include <pthread.h>

#define SIZE 3

int A[SIZE][SIZE] = {

{1, 2, 3},

{4, 5, 6},

{7, 8, 9}

};

int B[SIZE][SIZE] = {

{9, 8, 7},

{6, 5, 4},

{3, 2, 1}

};

int C[SIZE][SIZE];

void\* add\_matrices(void\* arg)

{

int i = \*(int\*)arg;

for (int j = 0; j < SIZE; j++)

{

C[i][j] = A[i][j] + B[i][j];

}

return NULL;

}

int main()

{

pthread\_t threads[SIZE];

int row[SIZE];

// Create one thread for each row

for (int i = 0; i < SIZE; i++)

{

row[i] = i;

pthread\_create(&threads[i], NULL, add\_matrices, &row[i]);

}

// Wait for all threads

for (int i = 0; i < SIZE; i++)

{

pthread\_join(threads[i], NULL);

}

printf("Resultant Matrix:\n");

for (int i = 0; i < SIZE; i++)

{

for (int j = 0; j < SIZE; j++)

{

printf("%d ", C[i][j]);

}

printf("\n");

}

return 0;

}

**Program 3: Implement Parallel Search in an Array**

#include <stdio.h>

#include <pthread.h>

#define SIZE 100

#define NUM\_THREADS 4

int data[SIZE];

int search\_value;

int found\_index = -1;

pthread\_mutex\_t lock;

/\* Thread function \*/

void\* search(void\* arg)

{

int thread\_id = \*(int\*)arg;

int start = thread\_id \* (SIZE / NUM\_THREADS);

int end = start + (SIZE / NUM\_THREADS);

printf("Thread %d searching from index %d to %d\n",

thread\_id, start, end - 1);

for (int i = start; i < end; i++)

{

if (data[i] == search\_value)

{

pthread\_mutex\_lock(&lock);

/\* Store the index if this is the first match \*/

if (found\_index == -1)

{

found\_index = i;

}

pthread\_mutex\_unlock(&lock);

return NULL;

}

}

return NULL;

}

int main()

{

pthread\_t threads[NUM\_THREADS];

int thread\_ids[NUM\_THREADS];

/\* Step 1: Initialize the array \*/

for (int i = 0; i < SIZE; i++)

{

data[i] = i + 1;

}

/\* Step 2: Get the value to search \*/

printf("Enter the number to search (1-100): ");

scanf("%d", &search\_value);

/\* Step 3: Initialize the mutex \*/

pthread\_mutex\_init(&lock, NULL);

/\* Step 4: Create threads \*/

for (int i = 0; i < NUM\_THREADS; i++)

{

thread\_ids[i] = i;

pthread\_create(&threads[i],

NULL,

search,

(void\*)&thread\_ids[i]);

}

/\* Step 5: Wait for all threads to finish \*/

for (int i = 0; i < NUM\_THREADS; i++)

{

pthread\_join(threads[i], NULL);

}

/\* Step 6: Display the result \*/

if (found\_index != -1)

{

printf("\nNumber %d found at index: %d\n",

search\_value, found\_index);

}

else

{

printf("\nNumber %d not found in the array.\n",

search\_value);

}

/\* Step 7: Destroy the mutex \*/

pthread\_mutex\_destroy(&lock);

return 0;

}

**Step-by-Step Explanation**:

1. Array Initialization: The `data` array is populated with integers from 1 to 100.

2. Thread Functionality: Each thread searches a quarter of the array for the number 50.

3. Mutex Locking: A mutex is used to protect access to the shared variable `found\_index`.

4. Real-life Use Case: This program simulates how databases might search through large datasets, utilizing multiple threads to improve speed.

**Expected Output**

Enter the number to search (1-100): 25

Thread 0 searching from index 0 to 24

Thread 2 searching from index 50 to 74

Thread 3 searching from index 75 to 99

Thread 1 searching from index 25 to 49

Number 25 found at index: 24

**Program 4: Implement multi-threading to simulate concurrent bank transactions.**

#include <stdio.h>

#include <pthread.h>

#define NUM\_THREADS 4

int balance = 10000; // Initial bank balance

pthread\_mutex\_t lock;

/\* Thread function for bank transaction \*/

void\* transaction(void\* arg)

{

int thread\_id = \*(int\*)arg;

int amount = 1000;

/\* Lock before accessing shared balance \*/

pthread\_mutex\_lock(&lock);

printf("Thread %d started transaction.\n", thread\_id);

printf("Thread %d: Balance before transaction = %d\n",

thread\_id, balance);

if (balance >= amount)

{

balance = balance - amount;

printf("Thread %d: Withdrawn = %d\n",

thread\_id, amount);

printf("Thread %d: Balance after transaction = %d\n\n",

thread\_id, balance);

}

else

{

printf("Thread %d: Insufficient balance\n\n",

thread\_id);

}

/\* Unlock after updating balance \*/

pthread\_mutex\_unlock(&lock);

return NULL;

}

int main()

{

pthread\_t threads[NUM\_THREADS];

int thread\_ids[NUM\_THREADS];

/\* Initialize mutex \*/

pthread\_mutex\_init(&lock, NULL);

printf("Initial Bank Balance = %d\n\n", balance);

/\* Create threads \*/

for (int i = 0; i < NUM\_THREADS; i++)

{

thread\_ids[i] = i + 1;

pthread\_create(&threads[i],

NULL,

transaction,

&thread\_ids[i]);

}

/\* Wait for all threads \*/

for (int i = 0; i < NUM\_THREADS; i++)

{

pthread\_join(threads[i], NULL);

}

printf("Final Bank Balance = %d\n", balance);

/\* Destroy mutex \*/

pthread\_mutex\_destroy(&lock);

return 0;

}

**Step-by-Step Explanation:**

1. Account Initialization: The bank account is initialized with an initial balance of ₹10,000.
2. Thread Functionality: Multiple threads are created to simulate concurrent bank transactions. Each thread performs a withdrawal of ₹1,000 from the shared bank account.
3. Mutex Locking: A mutex is used to protect access to the shared variable balance. It ensures that only one thread can update the account balance at a time and prevents race conditions.
4. Transaction Processing: Each thread checks whether sufficient balance is available. If sufficient funds exist, the withdrawal is performed and the updated balance is displayed.
5. Thread Synchronization: pthread\_join() is used to ensure that the main program waits for all transaction threads to complete before displaying the final account balance.
6. Real-life Use Case: This program simulates how multiple customers or banking applications may perform transactions on a shared bank account concurrently, demonstrating the importance of synchronization in multi-threaded systems.

**Expected Output**

Initial Bank Balance = 10000

Thread 1 started transaction.

Thread 1: Balance before transaction = 10000

Thread 1: Withdrawn = 1000

Thread 1: Balance after transaction = 9000

Thread 2 started transaction.

Thread 2: Balance before transaction = 9000

Thread 2: Withdrawn = 1000

Thread 2: Balance after transaction = 8000

Thread 3 started transaction.

Thread 3: Balance before transaction = 8000

Thread 3: Withdrawn = 1000

Thread 3: Balance after transaction = 7000

Thread 4 started transaction.

Thread 4: Balance before transaction = 7000

Thread 4: Withdrawn = 1000

Thread 4: Balance after transaction = 6000

Final Bank Balance = 6000

**Program 5: Implement Parallel Sorting with Merge Sort**

**Case Study**: Sorting large datasets is a common task in many applications, such as database management systems, where data needs to be ordered for efficient querying

#include <stdio.h>

#include <stdlib.h>

#include <pthread.h>

#define SIZE 100

#define NUM\_THREADS 4

int array[SIZE];

int temp[SIZE];

/\* Merge two sorted portions \*/

void merge(int left, int mid, int right)

{

int i = left;

int j = mid + 1;

int k = left;

while (i <= mid && j <= right)

{

if (array[i] <= array[j])

temp[k++] = array[i++];

else

temp[k++] = array[j++];

}

while (i <= mid)

temp[k++] = array[i++];

while (j <= right)

temp[k++] = array[j++];

for (i = left; i <= right; i++)

array[i] = temp[i];

}

/\* Normal recursive merge sort \*/

void merge\_sort(int left, int right)

{

if (left < right)

{

int mid = (left + right) / 2;

merge\_sort(left, mid);

merge\_sort(mid + 1, right);

merge(left, mid, right);

}

}

/\* Function executed by each pthread \*/

void \*thread\_merge\_sort(void \*arg)

{

int thread\_id = \*(int \*)arg;

int chunk = SIZE / NUM\_THREADS;

int left = thread\_id \* chunk;

int right = left + chunk - 1;

printf("Thread %d sorting elements %d to %d\n",

thread\_id, left, right);

merge\_sort(left, right);

return NULL;

}

int main()

{

pthread\_t threads[NUM\_THREADS];

int thread\_ids[NUM\_THREADS];

/\* Initialize array \*/

for (int i = 0; i < SIZE; i++)

{

array[i] = rand() % 1000;

}

printf("Original Array:\n");

for (int i = 0; i < SIZE; i++)

{

printf("%d ", array[i]);

}

printf("\n\n");

/\* Create threads \*/

for (int i = 0; i < NUM\_THREADS; i++)

{

thread\_ids[i] = i;

pthread\_create(

&threads[i],

NULL,

thread\_merge\_sort,

&thread\_ids[i]

);

}

/\* Wait for all threads \*/

for (int i = 0; i < NUM\_THREADS; i++)

{

pthread\_join(threads[i], NULL);

}

/\*

Now each quarter is sorted:

0 - 24

25 - 49

50 - 74

75 - 99

\*/

/\* Merge first two quarters \*/

merge(0, 24, 49);

/\* Merge last two quarters \*/

merge(50, 74, 99);

/\* Merge the two halves \*/

merge(0, 49, 99);

printf("\nSorted Array:\n");

for (int i = 0; i < SIZE; i++)

{

printf("%d ", array[i]);

}

printf("\n");

return 0;

}

**Sample Output**

Original Array:

383 886 777 915 793 335 386 492 649 421 362 27 690 59 763 926 540 426 172 736 211 368 567 429 782 530 862 123 67 135 929 802 22 58 69 167 393 456 11 42 229 373 421 919 784 537 198 324 315 370 413 526 91 980 956 873 862 170 996 281 305 925 84 327 336 505 846 729 313 857 124 895 582 545 814 367 434 364 43 750 87 808 276 178 788 584 403 651 754 399 932 60 676 368 739 12 226 586 94 539

Thread 2 sorting elements 50 to 74

Thread 3 sorting elements 75 to 99

Thread 0 sorting elements 0 to 24

Thread 1 sorting elements 25 to 49

Sorted Array:

11 12 22 27 42 43 58 59 60 67 69 84 87 91 94 123 124 135 167 170 172 178 198 211 226 229 276 281 305 313 315 324 327 335 336 362 364 367 368 368 370 373 383 386 393 399 403 413 421 421 426 429 434 456 492 505 526 530 537 539 540 545 567 582 584 586 649 651 676 690 729 736 739 750 754 763 777 782 784 788 793 802 808 814 846 857 862 862 873 886 895 915 919 925 926 929 932 956 980 996

**Step-by-Step Explanation:**

1. **Merge Function**: This function merges two sorted halves of the array.
2. **. Merge Sort Implementation**: Each thread sorts a quarter of the array concurrently.
3. **Array Initialization**: The array is filled with random numbers.
4. **Real-life Use Case**: This program illustrates how multi-core processors can handle large sorting tasks efficiently, a common operation in data processing applications

**Program 6: Implement a producer-consumer model using threads for task management.**

**Case Study:**Task management is a common requirement in operating systems and multi-core applications, where tasks are generated and processed concurrently. The Producer–Consumer model demonstrates how one thread can generate tasks while another thread consumes and processes them using a shared buffer.

#include <stdio.h>

#include <stdlib.h>

#include <pthread.h>

#include <unistd.h>

#define BUFFER\_SIZE 5

#define NUM\_TASKS 10

int buffer[BUFFER\_SIZE];

int in = 0;

int out = 0;

int count = 0;

pthread\_mutex\_t mutex;

pthread\_cond\_t not\_full;

pthread\_cond\_t not\_empty;

/\* Producer thread \*/

void \*producer(void \*arg)

{

for (int task = 1; task <= NUM\_TASKS; task++)

{

pthread\_mutex\_lock(&mutex);

/\* Wait if buffer is full \*/

while (count == BUFFER\_SIZE)

{

printf("Producer: Buffer full, waiting...\n");

pthread\_cond\_wait(&not\_full, &mutex);

}

/\* Add task to buffer \*/

buffer[in] = task;

printf("Producer: Produced task %d\n", task);

in = (in + 1) % BUFFER\_SIZE;

count++;

/\* Tell consumer that buffer is not empty \*/

pthread\_cond\_signal(&not\_empty);

pthread\_mutex\_unlock(&mutex);

sleep(1);

}

return NULL;

}

/\* Consumer thread \*/

void \*consumer(void \*arg)

{

for (int i = 1; i <= NUM\_TASKS; i++)

{

pthread\_mutex\_lock(&mutex);

/\* Wait if buffer is empty \*/

while (count == 0)

{

printf("Consumer: Buffer empty, waiting...\n");

pthread\_cond\_wait(&not\_empty, &mutex);

}

/\* Remove task from buffer \*/

int task = buffer[out];

printf("Consumer: Consumed task %d\n", task);

out = (out + 1) % BUFFER\_SIZE;

count--;

/\* Tell producer that buffer is not full \*/

pthread\_cond\_signal(&not\_full);

pthread\_mutex\_unlock(&mutex);

/\* Simulate task processing \*/

sleep(2);

}

return NULL;

}

int main()

{

pthread\_t producer\_thread;

pthread\_t consumer\_thread;

/\* Initialize mutex \*/

pthread\_mutex\_init(&mutex, NULL);

/\* Initialize condition variables \*/

pthread\_cond\_init(&not\_full, NULL);

pthread\_cond\_init(&not\_empty, NULL);

/\* Create producer \*/

pthread\_create(

&producer\_thread,

NULL,

producer,

NULL

);

/\* Create consumer \*/

pthread\_create(

&consumer\_thread,

NULL,

consumer,

NULL

);

/\* Wait for both threads \*/

pthread\_join(producer\_thread, NULL);

pthread\_join(consumer\_thread, NULL);

/\* Destroy synchronization objects \*/

pthread\_mutex\_destroy(&mutex);

pthread\_cond\_destroy(&not\_full);

pthread\_cond\_destroy(&not\_empty);

printf("\nAll tasks completed.\n");

return 0;

}

**Sample Output**

Producer: Produced task 1

Consumer: Consumed task 1

Producer: Produced task 2

Consumer: Consumed task 2

Producer: Produced task 3

Producer: Produced task 4

Consumer: Consumed task 3

Producer: Produced task 5

Producer: Produced task 6

Consumer: Consumed task 4

Producer: Produced task 7

Producer: Produced task 8

Consumer: Consumed task 5

Producer: Produced task 9

Producer: Produced task 10

Consumer: Consumed task 6

Consumer: Consumed task 7

Consumer: Consumed task 8

Consumer: Consumed task 9

Consumer: Consumed task 10

All tasks completed.

**Step-by-Step Explanation:**

**1. Producer Thread:** The producer thread generates tasks one by one and places them into the shared buffer. It waits if the buffer becomes full.

**2. Consumer Thread:** The consumer thread retrieves tasks from the shared buffer and processes them. It waits if the buffer is empty.

**3. Shared Buffer:** A fixed-size buffer is used to temporarily store the tasks produced by the producer. The in and out variables keep track of where tasks are inserted and removed.

**4. Mutex and Condition Variables:** A mutex is used to ensure that only one thread accesses the shared buffer at a time. Condition variables allow the producer to wait when the buffer is full and the consumer to wait when the buffer is empty.

**5. Thread Creation and Synchronization:** Pthreads are created using pthread\_create(), and pthread\_join() is used to ensure that the main program waits until both the producer and consumer threads complete their tasks.

**6. Real-Life Use Case:** This program illustrates how multi-core systems can handle task generation and task processing concurrently. Similar producer–consumer models are used in operating-system task scheduling, print queues, data processing pipelines, web servers, and job-processing systems.

**Program 7: Implement condition variables to manage thread communication in production scenarios.**

**Condition Variables for Thread Communication**

**Case Study:** Producer-consumer problems illustrate how different threads can communicate. In a bakery, bakers (producers) need to signal when bread is ready for delivery (consumers).

**Program:**

#include <stdio.h>

#include <pthread.h>

#include <unistd.h>

#define MAX\_BREAD 10

int bread\_count = 0; // Current number of bread loaves

pthread\_mutex\_t lock; // Mutex for synchronizing access to bread\_count

pthread\_cond\_t cond; // Condition variable

**// Step 1: Function for the producer thread**

void\* producer(void\* arg) {

while (1) {

pthread\_mutex\_lock(&lock);

while (bread\_count >= MAX\_BREAD) {

pthread\_cond\_wait(&cond, &lock); // Wait for the consumer

}

bread\_count++; // Produce a loaf of bread

printf("Produced bread. Total: %d\n", bread\_count);

pthread\_cond\_signal(&cond); // Signal the consumer

pthread\_mutex\_unlock(&lock);

sleep(1); // Simulate time taken to produce bread

}

return NULL;

}

**// Step 2: Function for the consumer thread**

void\* consumer(void\* arg) {

while (1) {

pthread\_mutex\_lock(&lock);

while (bread\_count <= 0) {

pthread\_cond\_wait(&cond, &lock); // Wait for the producer

}

bread\_count--; // Consume a loaf of bread

printf("Consumed bread. Remaining: %d\n", bread\_count);

pthread\_cond\_signal(&cond); // Signal the producer

pthread\_mutex\_unlock(&lock);

sleep(1); // Simulate time taken to consume bread

}

return NULL;

}

int main() {

pthread\_t prod\_thread, cons\_thread;

pthread\_mutex\_init(&lock, NULL);

pthread\_cond\_init(&cond, NULL);

// Step 3: Create producer and consumer threads

pthread\_create(&prod\_thread, NULL, producer, NULL);

pthread\_create(&cons\_thread, NULL, consumer, NULL);

// Step 4: Join threads (they will run indefinitely in this example)

pthread\_join(prod\_thread, NULL);

pthread\_join(cons\_thread, NULL);

pthread\_mutex\_destroy(&lock);

pthread\_cond\_destroy(&cond);

return 0;

**Step-by-Step Explanation:**

**1. Shared Resource:** The variable `bread\_count` keeps track of the number of loaves produced.

**2. Condition Variable:** The producer waits if the maximum limit is reached, while the consumer waits if there are no loaves available.

**3. Thread Interaction:** The producer and consumer signal each other using the condition variable, allowing for smooth production and consumption.

**4. Real-life Use Case:** This illustrates the producer-consumer problem, which is common in manufacturing systems where resources must be managed between different processes.

**Program 8: Implement Parallel array Summation using OpenMP for performance optimization**

#include <stdio.h>

#include <stdlib.h>

#include <omp.h>

#define SIZE 1000000

int array[SIZE];

int main() {

// -----------------------------------------

// Step 1: Initialize the array

// -----------------------------------------

for (int i = 0; i < SIZE; i++) {

array[i] = rand() % 100;

}

// -----------------------------------------

// Step 2: Sequential calculation

// -----------------------------------------

int sequential\_sum = 0;

double start = omp\_get\_wtime();

for (int i = 0; i < SIZE; i++) {

sequential\_sum += array[i];

}

double end = omp\_get\_wtime();

printf("\n===== SEQUENTIAL =====\n");

printf("Sum : %d\n", sequential\_sum);

printf("Time : %f seconds\n", end - start);

// -----------------------------------------

// Step 3: Parallel calculation

// -----------------------------------------

int parallel\_sum = 0;

start = omp\_get\_wtime();

#pragma omp parallel for reduction(+:parallel\_sum)

for (int i = 0; i < SIZE; i++) {

parallel\_sum += array[i];

}

end = omp\_get\_wtime();

printf("\n===== PARALLEL =====\n");

printf("Sum : %d\n", parallel\_sum);

printf("Time : %f seconds\n", end - start);

// -----------------------------------------

// Step 4: Display number of threads

// -----------------------------------------

printf("\n===== THREAD INFORMATION =====\n");

#pragma omp parallel

{

printf("Hello from thread %d of %d\n",

omp\_get\_thread\_num(),

omp\_get\_num\_threads());

}

// -----------------------------------------

// Step 5: Verify results

// -----------------------------------------

printf("\n===== RESULT CHECK =====\n");

if (sequential\_sum == parallel\_sum) {

printf("Both sums are equal.\n");

} else {

printf("Results are different!\n");

}

return 0;

}

**Commands to Run**

Compilation

gcc -fopenmp programname.c -o programname

Execution

./programname

**Program 9: Implement task parallelism in image processing applications using OpenMP.**

OpenMP Task Parallelism

Case Study: Image processing can benefit from task parallelism, where different tasks, such as blurring or sharpening, are applied to sections of an image simultaneously.

**Program:**

#include <stdio.h>

#include <omp.h>

#define NUM\_TASKS 4

// Task 1: Blur the image

void blur()

{

printf("Thread %d: Blurring the image...\n",

omp\_get\_thread\_num());

}

// Task 2: Sharpen the image

void sharpen()

{

printf("Thread %d: Sharpening the image...\n",

omp\_get\_thread\_num());

}

// Task 3: Adjust contrast

void contrast()

{

printf("Thread %d: Adjusting image contrast...\n",

omp\_get\_thread\_num());

}

// Task 4: Resize the image

void resize\_image()

{

printf("Thread %d: Resizing the image...\n",

omp\_get\_thread\_num());

}

int main()

{

double start\_time, end\_time;

printf("OpenMP Task Parallelism - Image Processing\n");

printf("Number of tasks: %d\n\n", NUM\_TASKS);

start\_time = omp\_get\_wtime();

/\*

Parallel region:

A team of OpenMP threads is created.

\*/

#pragma omp parallel

{

/\*

Single:

Only one thread creates the tasks.

Other threads are available to execute them.

\*/

#pragma omp single

{

printf("Tasks are being created by Thread %d\n\n",

omp\_get\_thread\_num());

// Create Task 1

#pragma omp task

{

blur();

}

// Create Task 2

#pragma omp task

{

sharpen();

}

// Create Task 3

#pragma omp task

{

contrast();

}

// Create Task 4

#pragma omp task

{

resize\_image();

}

/\*

Wait until all previously created tasks

are completed.

\*/

#pragma omp taskwait

printf("\nAll image processing tasks completed.\n");

}

}

end\_time = omp\_get\_wtime();

printf("Execution time: %f seconds\n",

end\_time - start\_time);

return 0;

}

**Step-by-Step Explanation**:

1. Task Functions: Each function simulates a different image processing task.

2. Task Parallelism with OpenMP: The `#pragma omp task` directive creates independent tasks that

can be executed concurrently by available threads.

3. Real-life Use Case: This program simulates how different image processing tasks can be executed

simultaneously in an image editing application, leading to faster results.

**Program 10: Implement timeout mechanisms to handle deadlocks effectively**

Handling Deadlocks with Timeouts Case Study: Database systems often face deadlocks when multiple transactions lock resources. Implementing timeouts can help resolve these situations.

#define \_POSIX\_C\_SOURCE 200809L

#include <stdio.h>

#include <pthread.h>

#include <unistd.h>

#include <time.h>

#include <errno.h>

#define NUM\_THREADS 2

pthread\_mutex\_t lock1;

pthread\_mutex\_t lock2;

// Step 1: Function for threads to simulate resource locking

void\* thread\_function(void\* arg)

{

int thread\_id = \*(int\*)arg;

if (thread\_id == 0)

{

pthread\_mutex\_lock(&lock1); // Lock resource 1

sleep(1); // Simulate some work

printf("Thread 0: Waiting for lock 2...\n");

// Set timeout of 2 seconds

struct timespec deadline;

clock\_gettime(CLOCK\_REALTIME, &deadline);

deadline.tv\_sec += 2;

// Try to acquire lock 2 within the timeout

int result = pthread\_mutex\_timedlock(&lock2, &deadline);

if (result == ETIMEDOUT)

{

printf("Thread 0: Timeout! Releasing lock 1.\n");

pthread\_mutex\_unlock(&lock1);

}

else if (result != 0)

{

printf("Thread 0: Error acquiring lock 2.\n");

pthread\_mutex\_unlock(&lock1);

}

else

{

printf("Thread 0: Acquired lock 2.\n");

pthread\_mutex\_unlock(&lock2);

pthread\_mutex\_unlock(&lock1);

}

}

else

{

pthread\_mutex\_lock(&lock2); // Lock resource 2

sleep(1); // Simulate some work

printf("Thread 1: Waiting for lock 1...\n");

// Set timeout of 2 seconds

struct timespec deadline;

clock\_gettime(CLOCK\_REALTIME, &deadline);

deadline.tv\_sec += 2;

// Try to acquire lock 1 within the timeout

int result = pthread\_mutex\_timedlock(&lock1, &deadline);

if (result == ETIMEDOUT)

{

printf("Thread 1: Timeout! Releasing lock 2.\n");

pthread\_mutex\_unlock(&lock2);

}

else if (result != 0)

{

printf("Thread 1: Error acquiring lock 1.\n");

pthread\_mutex\_unlock(&lock2);

}

else

{

printf("Thread 1: Acquired lock 1.\n");

pthread\_mutex\_unlock(&lock1);

pthread\_mutex\_unlock(&lock2);

}

}

return NULL;

}

int main(void)

{

pthread\_t threads[NUM\_THREADS];

int thread\_ids[NUM\_THREADS] = {0, 1};

// Initialize mutex locks

pthread\_mutex\_init(&lock1, NULL);

pthread\_mutex\_init(&lock2, NULL);

// Step 2: Create threads

for (int i = 0; i < NUM\_THREADS; i++)

{

pthread\_create(&threads[i], NULL,

thread\_function, &thread\_ids[i]);

}

// Step 3: Join threads

for (int i = 0; i < NUM\_THREADS; i++)

{

pthread\_join(threads[i], NULL);

}

// Destroy mutex locks

pthread\_mutex\_destroy(&lock1);

pthread\_mutex\_destroy(&lock2);

return 0;

}

**Step-by-Step Explanation:**

**1. Multiple Locks**: Two mutexes, `lock1` and `lock2`, are initialized to simulate resource locking.

**2. Try Locking**: Each thread attempts to lock its designated mutex and then tries to acquire the other mutex without blocking.

**3. Real-life Use Case**: This program simulates how a database transaction management system can prevent deadlocks by implementing timeout mechanisms and checking lock availability.

**Sample Output**

Thread 0: Waiting for lock 2...

Thread 1: Waiting for lock 1...

Thread 0: Timeout! Releasing lock 1.

Thread 1: Timeout! Releasing lock 2.

**Program 11: Implement a work-stealing scheduler to optimize task processing among threads.**

Work-Stealing Scheduler Case Study: A web server processing multiple requests can benefit from work-stealing, allowing idle threads to pick up tasks from busy threads, enhancing resource utilization.

#include <stdio.h>

#include <pthread.h>

#include <stdlib.h>

#include <unistd.h>

#define NUM\_TASKS 10

#define NUM\_THREADS 4

int queues[NUM\_THREADS][NUM\_TASKS];

int queue\_size[NUM\_THREADS];

pthread\_mutex\_t locks[NUM\_THREADS];

// Step 1: Process tasks using work-stealing

void\* process\_tasks(void\* arg)

{

int thread\_id = \*(int\*)arg;

while (1)

{

int task = -1;

// Step 2: Get a task from the thread's own queue

pthread\_mutex\_lock(&locks[thread\_id]);

if (queue\_size[thread\_id] > 0)

{

task = queues[thread\_id][--queue\_size[thread\_id]];

}

pthread\_mutex\_unlock(&locks[thread\_id]);

// Step 3: If no local task, steal from another thread

if (task == -1)

{

for (int i = 0; i < NUM\_THREADS; i++)

{

if (i == thread\_id)

continue;

pthread\_mutex\_lock(&locks[i]);

if (queue\_size[i] > 0)

{

task = queues[i][--queue\_size[i]];

}

pthread\_mutex\_unlock(&locks[i]);

if (task != -1)

{

printf("Thread %d stole task %d from Thread %d\n",

thread\_id, task, i);

break;

}

}

}

// Step 4: Stop when no task can be found

if (task == -1)

break;

// Step 5: Process the task

printf("Thread %d processing task %d\n", thread\_id, task);

sleep(1);

}

printf("Thread %d finished.\n", thread\_id);

return NULL;

}

int main(void)

{

pthread\_t threads[NUM\_THREADS];

int thread\_ids[NUM\_THREADS];

// Step 6: Initialize queues and mutexes

for (int i = 0; i < NUM\_THREADS; i++)

{

queue\_size[i] = 0;

pthread\_mutex\_init(&locks[i], NULL);

}

// Step 7: Initialize tasks

for (int i = 1; i <= NUM\_TASKS; i++)

{

int owner;

// Deliberately assign most tasks to Thread 0

if (i <= 7)

owner = 0;

else

owner = i - 7;

queues[owner][queue\_size[owner]++] = i;

}

// Step 8: Display initial thread queues

printf("Initial Thread Queues:\n");

for (int i = 0; i < NUM\_THREADS; i++)

{

printf("Thread %d: ", i);

for (int j = 0; j < queue\_size[i]; j++)

printf("%d ", queues[i][j]);

printf("\n");

}

printf("\nStarting work-stealing scheduler...\n\n");

// Step 9: Create threads

for (int i = 0; i < NUM\_THREADS; i++)

{

thread\_ids[i] = i;

pthread\_create(&threads[i], NULL,

process\_tasks, &thread\_ids[i]);

}

// Step 10: Wait for all threads

for (int i = 0; i < NUM\_THREADS; i++)

pthread\_join(threads[i], NULL);

// Step 11: Destroy mutexes

for (int i = 0; i < NUM\_THREADS; i++)

pthread\_mutex\_destroy(&locks[i]);

printf("\nAll tasks completed successfully.\n");

return 0;

}

**Step-by-Step Explanation:**

**1. Task Initialization**: An array of tasks is initialized.

**2. Task Processing**: Each thread processes tasks based on its thread ID, skipping ahead by the total number of threads.

**3. Real-life Use Case**: This illustrates how a web server might distribute requests among threads, where each thread picks up tasks based on its ID, maximizing efficiency and minimizing idle time.

**Sample Output**

Initial Thread Queues:

Thread 0: 1 2 3 4 5 6 7

Thread 1: 8

Thread 2: 9

Thread 3: 10

Starting work-stealing scheduler...

Thread 0 processing task 7

Thread 1 processing task 8

Thread 2 processing task 9

Thread 3 processing task 10

Thread 0 processing task 6

Thread 1 stole task 5 from Thread 0

Thread 1 processing task 5

Thread 2 stole task 4 from Thread 0

Thread 2 processing task 4

Thread 3 stole task 3 from Thread 0

Thread 3 processing task 3

Thread 0 processing task 2

Thread 1 stole task 1 from Thread 0

Thread 1 processing task 1

Thread 2 finished.

Thread 3 finished.

Thread 0 finished.

Thread 1 finished.

All tasks completed successfully.