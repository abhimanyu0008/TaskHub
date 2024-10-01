import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit{

  selectedTask= {
    id: 0,
    title: '',
    description: '',
    status: '',
    date: ''
  };

  constructor(
    private service: TaskService,
    private router: Router,
    private activeRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.activeRoute.snapshot.paramMap.get('id');
    this.getTask(id);
  }

  getTask(id: any) {
    this.service.getTaskById(id).subscribe((response) => {
      this.selectedTask = response;  
    }, (error) => {
      console.error('Error fetching task', error);
    });
  }

  updateTask() {
    this.service.updateTask(this.selectedTask).subscribe((data) => {
        this.router.navigate(['/view-task']).then(() => {
            alert("Update successful");
        });
    }, (error) => {
        console.log('Error updating task', error);
    });
}

}
