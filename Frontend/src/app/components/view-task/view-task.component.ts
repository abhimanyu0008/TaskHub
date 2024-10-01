import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit{

  constructor(private service:TaskService,private router:Router) {}

  ngOnInit(): void {
    this.getAllTask();
  }
  task:any;
  getAllTask(){
    this.service.getAllTask().subscribe((response)=>{
      this.task=response;
    })
  }
  // deleteTask(id:any){
  //   this.service.deleteTask(id).subscribe((data)=>{
  //     this.getAllTask();
  //   })
  // }

  tasks: any[] = [];

  deleteTask(id: number) {
    if (confirm('Are you sure you want to delete this task?')) {
      this.service.deleteTask(id).subscribe(
        (response) => {
          console.log('Task deleted successfully:', response); // Log the response
          // Remove the deleted task from the tasks array
          this.tasks = this.tasks.filter(task => task.id !== id);
        },
        (error) => {
          console.error('Error deleting task:', error);
        }
      );
    }
  }
  
  
}
