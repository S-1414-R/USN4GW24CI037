#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure to store student details
struct Student {
    char usn[20];
    char name[50];
    int sem;
    float marks;
    struct Student *next;
};

// Head pointer for linked list
struct Student *head = NULL;

// Function to add a student
void addStudent() {
    struct Student *newNode;
    newNode = (struct Student *)malloc(sizeof(struct Student));

    printf("Enter USN: ");
    scanf("%s", newNode->usn);

    printf("Enter Name: ");
    scanf("%s", newNode->name);

    printf("Enter Semester: ");
    scanf("%d", &newNode->sem);

    printf("Enter Marks: ");
    scanf("%f", &newNode->marks);

    newNode->next = head;
    head = newNode;

    printf("Student record added successfully!\n");
}

// Function to display all students
void displayStudents() {
    struct Student *temp = head;

    if (temp == NULL) {
        printf("No student records found.\n");
        return;
    }

    printf("\nStudent Records:\n");
    while (temp != NULL) {
        printf("-------------------------\n");
        printf("USN: %s\n", temp->usn);
        printf("Name: %s\n", temp->name);
        printf("Semester: %d\n", temp->sem);
        printf("Marks: %.2f\n", temp->marks);
        temp = temp->next;
    }
}

// Function to delete a student using USN
void deleteStudent() {
    char usn[20];
    struct Student *temp = head, *prev = NULL;

    printf("Enter USN to delete: ");
}