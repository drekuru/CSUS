#include <stdio.h>

int main(void) {

unsigned int sum = 0x89ABCDEF;
unsigned int iData [  ] = {  0xFF00FF15, 0xFF00FF14, 0xFF00FF13, 0xFF00FF12 } ;
unsigned int *Ptr1 , *Ptr2; 

  Ptr1 = &sum;

  //printf ( "%#x",  *Ptr1 ) ;

  Ptr2 = iData;

  //printf ( " %#x ",   *Ptr2 ) ;

  Ptr2++ ;

  //printf ( " %#x ",   *Ptr2 ) ; 

  Ptr2++ ; 
  Ptr2++ ; 

  //printf ( " %#x ",   *Ptr2 ) ;

  Ptr2 = Ptr1 ;

  //printf ( " %#x ",   *Ptr2 ) ;

  unsigned int y = 0x89AB45CD ;
  y = 0x45CD89AB ;
  //unsigned int *Ptr1 , *Ptr2; 

  Ptr1 = &y ;   

  Ptr2   =   Ptr1 ;

  //printf ( "  %#x \n  ", * Ptr1 ) ;  
  
  //printf ( "  %#x \n  ", *Ptr2 ) ;

  //printf ( "  %#x \n  ", * Ptr1 ) ; 

  Ptr2 =  iData + 2 ;

  Ptr1 = Ptr2  ;

  //printf ( "  %#x  ",   * Ptr1 ) ; 

  Ptr2 =  iData + 1 ;

  //printf ( " %#x  " ,   *  Ptr2 ) ;

  //unsigned short   dataBuf [ 4 ]  =  {  0xFF00, 0x0F0E, 0xdead, 0xbeef}  ;

  //dataBuf++   ;

  //dataBuf =  20 ; 

  //unsigned char count ;

  //unsigned char  *extraPtr1 = 10 ;   

  //unsigned char extraPtr2 =  &count ; 

  //unsigned short sh ;

  //unsigned short *shortPtr1 = sh  ; 
  //unsigned short *shortPtr2 = &sh  ;  

  unsigned int numData [ 10 ] = { 0x19, 0xFF12FF13, 0xFF00FF12, 0x43, 0x87, 0x34 } ;
  int * numPtr = numData + 1 ;
  numPtr  = numPtr + 1 ;
  
  //printf ( "  %#x  ",   * numPtr ) ;

  *numPtr = *numPtr + 20 ;

  printf ( "  %#x  ",   * numPtr ) ;

  return 0;
}