import os
import sys

if len(sys.argv)!=2:
    print("Usage: python ping.py<hostname_or_ip>")
    sys.exit(1)

host = sys.argv[1]
respose = os.system(f"ping -c 4 {host}")

if respose == 0:
    print("Host is alive")
else:
    print("host died")