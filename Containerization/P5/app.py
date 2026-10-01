import csv

filename = "students.csv"
students = []

with open(filename,newline='') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        students.append((row['Name'],int(row['Marks'])))

print("Students mark viz")

if students:
    max_name_len=max(len(name) for name,_ in students)
    max_marks = max(marks for _, marks in students)

    for name,marks in students:
        bar = '/'*(marks*50//max_marks)
        print(f"{name.ljust(max_name_len)} | {bar} {marks}")
else:
    print("No student data available.")