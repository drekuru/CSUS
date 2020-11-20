#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define MAX_LINE  32
int main(int argc, char *argv[])
{
    char message[ ] = "I am the child This is Spring 2020";
    char buf[1000];
     int pipefd[2];
     pid_t cpid;

     if (pipe(pipefd) == -1) //catch error here
     {
         perror("pipe");
         exit(EXIT_FAILURE);
     }

     cpid = fork();

     if (cpid == -1)//catch other errors
     {
          perror("fork");
          exit(EXIT_FAILURE);
     }

     if (cpid == 0)
     { 
        printf("\nInside Child\n");

        close(pipefd[0]);//closing read end
        write(pipefd[1], message, strlen(message));//pipe to parent
        close(pipefd[1]);//close pipe end
        exit(0);
       
     }
     else
     {  
        printf("\nInside Parent\n");

        wait(NULL); //waiting for child
        close(pipefd[1]);//closing write end
        int r = read(pipefd[0], &buf, 1000); //reading into buf
        buf[r] = '\0';
        close(pipefd[0]); //closing read end of pipe
        printf ("\nBack To Parent Process\n\n");
        printf( "%s \n", buf );      
     }
    exit( EXIT_SUCCESS);
}
