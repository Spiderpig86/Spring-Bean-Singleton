from threading import Thread
import time
import requests

def increment_number(name, delay):
    count = 0
    for i in range(50):
        time.sleep(delay)

        count = requests.get('http://localhost:8080/increment')
        print(f'{name} - {count.text}')

def _reset():
    requests.post('http://localhost:8080/reset')

def _get_random_string(length):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(length))

THREAD_COUNT = 4
threads = []
try:
    for i in range(THREAD_COUNT):
        t = Thread(target=increment_number, args=(f'Thread {i}', 0.05))
        t.start()
        threads.append(t)
except:
    print('Unable to create threads')

for t in threads:
    t.join()