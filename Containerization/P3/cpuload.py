import time
print("Staring CPU load test...")
start = time.time()
x=0
while time.time() - start < 30:
    for i in range(1000000):
        x += i*i
print("Task Completed")