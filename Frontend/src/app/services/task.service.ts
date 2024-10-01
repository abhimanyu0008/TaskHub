import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8081/tasks';

  addTask(task: any): Observable<any> {
    return this.http.post(this.baseUrl, task, { responseType: 'text' });
  }
  getAllTask(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
  getTaskById(id: any): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  updateTask(task: any): Observable<any> {
    return this.http.put(this.baseUrl,task,{ responseType: 'text' });
  }
  deleteTask(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, 
      { responseType: 'text' });
  }
}
