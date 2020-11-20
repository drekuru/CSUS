#include<stdio.h>
#include<sys/types.h>
#include<sys/wait.h>

void main(void)
{
	int status;
	pid_t pid;
	pid = fork();
	if(pid == 0)
	{
		printf("Child Process Executing\n");
		system("./sum.sh 4 6 8");
	}
	else
	{
		wait(&status);
		if(WIFEXITED (status))
			printf("Child Died Successfully\n");
		else if(WIFSIGNALED(status))
			printf("Child Died From Error\n");
		printf("Parent Process Executing\n");
	}
}
