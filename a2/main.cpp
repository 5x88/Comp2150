/*
 * main.cpp
 *
 *  Created on: Feb 24, 2016
 *      Author: Mike
 */
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <time.h>
#include <string.h>

/*-----------------------------------------------------------------------------
 * DEFINES
 *----------------------------------------------------------------------------*/

#define FALSE 0
#define TRUE 1
#define EXITSUCCESS 1

/*-----------------------------------------------------------------------------
 * CONSTANTS and TYPES
 *----------------------------------------------------------------------------*/




/*-----------------------------------------------------------------------------
 * VARIABLES
 *----------------------------------------------------------------------------*/



/*-----------------------------------------------------------------------------
 * PROTOTYPES
 *----------------------------------------------------------------------------*/
void arival();
void startSerivice();
void completeService();
void openExpressLane();
void closeExpressLane();
void displayTerminationMessage(void);

int main()
{



	displayTerminationMessage();
	return EXIT_SUCCESS;
}


void arival()
{

}


void startSerivice()
{

}


void completeService()
{

}


void openExpressLane()
{

}


void closeExpressLane()
{

}

void displayTerminationMessage(void)
{
	time_t theTime; // the current time

	theTime = time(NULL);
	printf("\nProgrammed by Michael Alcock. \n");
	printf("Date: %s", ctime(&theTime));
	printf("End of proccessing. \n\n");
}
