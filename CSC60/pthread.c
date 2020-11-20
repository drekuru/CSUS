#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int x = 30; // shared var
pthread_mutex_t one_lock = PTHREAD_MUTEX_INITIALIZER;

void add1(void *a)
{
  pthread_mutex_lock(&one_lock); //unlock
  x += *((int *)a); //update 
  pthread_mutex_unlock(&one_lock);//lock 
  pthread_exit(NULL); //exit
}

void add2(void *b)
{
  pthread_mutex_lock(&one_lock);//unlock 
  x += *((int *)b); //update
  pthread_mutex_unlock(&one_lock);//lock
  pthread_exit(NULL); //exit
}

void add3(void *c)
{
  pthread_mutex_lock(&one_lock); //unlock
  x += *((int *)c);//update
  pthread_mutex_unlock(&one_lock); //update
  pthread_exit(NULL); //exit
}

int main()
{

  pthread_t T1, T2, T3; //create threads
  int x1 = 10, x2 = 20, x3 = 30; //vars
  int id1, id2, id3;

  id1 = pthread_create(&T1, NULL, (void *)add1, (void *)&x1); //add1
  id2 = pthread_create(&T2, NULL, (void *)add2, (void *)&x2); //add2
  id3 = pthread_create(&T3, NULL, (void *)add3, (void *)&x3); //add3

  pthread_join(T1, NULL); //await
  pthread_join(T2, NULL); //^
  pthread_join(T3, NULL); //^

  printf("%d\n", x); //print
}
