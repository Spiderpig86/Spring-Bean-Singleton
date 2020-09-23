from threading import Thread
import time
import requests
import string
import random

def increment_number(name, delay):
    count = 0
    for i in range(50):
        time.sleep(delay)

        count = requests.get('http://localhost:8080/increment')
        print(f'{name} - {count.text}')
    
def add_string(name, delay):
    words = ''
    for i in range(10):
        time.sleep(delay)

        requested_word = _get_random_string(5)
        print(f'{name} - Requesting with {requested_word}')
        words = requests.post('http://localhost:8080/addstring', data=requested_word)
        print(f'{name} - {words.text}')

def _reset():
    requests.post('http://localhost:8080/reset')

def _get_random_string(length):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(length))

_reset()
THREAD_COUNT = 4
threads = []
try:
    for i in range(THREAD_COUNT):
        t = Thread(target=add_string, args=(f'Thread {i}', 0.01))
        t.start()
        threads.append(t)
except:
    print('Unable to create threads')

for t in threads:
    t.join()