import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent {

  constructor(private service: TaskService, private router: Router) { }
  task = {
    id: null,
    title: '',
    description: '',
    status: '',
    date: '',
  }

  addTask(taskForm: NgForm) {
    // Check if all fields are filled
    if (!this.task.id || !this.task.title || !this.task.description || !this.task.status || !this.task.date) {
      alert('All fields are required. Please fill in all the details.');
      return;
    }

    if (taskForm.invalid) {
      Object.values(taskForm.controls).forEach(control => {
        control.markAsTouched();
      });
      return;
    }

    this.service.addTask(this.task).subscribe(
      (response) => {
        console.log('Raw Response:', response); 
        alert('Task added successfully');
        this.router.navigate(['/view-task']);
      },
      (error) => {
        console.error('Error adding task', error);
        alert('Failed to add task. Status: ' + error.status + ', Message: ' + error.message);
      }
    );
  }
}
