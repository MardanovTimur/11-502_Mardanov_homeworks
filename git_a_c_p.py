import os
import subprocess
from os.path import abspath

currentdir = str(os.curdir)


def write_git_add():
    command = "git add ."
    subprocess.run("cd "+abspath(currentdir),shell=True)
    os.system(command)

def write_git_commit(commit):
    command = "git commit -m " + str(commit)
    os.system(r'cd ' + abspath(currentdir))
    os.system(command)

def write_git_push():
    command = "git push -f origin master"
    os.system(r'cd ' + abspath(currentdir))
    os.system(command)
    os.system(r'exit')

if __name__ == "__main__":
    write_git_add()
    s = str(input("Please write the commit message: "))
    write_git_add()
    write_git_commit(s)
    write_git_push()
