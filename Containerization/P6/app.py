import os
print("ENV VAR")

for key, value in os.environ.items():
    print(f"{key}:{value}")