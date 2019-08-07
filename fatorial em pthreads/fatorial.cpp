#include <iostream>
#include <pthread.h>
#include<time.h>
pthread_mutex_t mutex= PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond=PTHREAD_COND_INITIALIZER;
using namespace std;

void *fat( void *threadid){

pthread_mutex_lock(&mutex); 
long tid;
int fat;
tid=(long)threadid;
cout<<" executando o fatorial de "<<tid<<"\n";
for(int i=tid-1 ;i>0;i--){
tid=tid*i;
}
cout<<tid<<"\n";
pthread_mutex_unlock(&mutex);
pthread_exit(NULL);
}



int main(){
  
pthread_t thread[10];
pthread_t threadr;
pthread_create(&threadr, NULL, imp, NULL);

for(long j=0;j<=9;j++){
long x;
cin>>x;

pthread_create(&thread[j], NULL, fat, (void*)x);
}

pthread_cond_signal(&cond);


  
pthread_exit(NULL);


}

pthread_cond_signal(&cond);


  
pthread_exit(NULL);


}
