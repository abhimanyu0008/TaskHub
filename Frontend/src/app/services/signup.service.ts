import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient) { }
  
  private url = 'http://localhost:8081/user/register-user';

  addUser(fullName: string, username: string,
    email: string, phone: string, password: string,
    gender: string): Observable<any> {
    return this.http.post(this.url, { fullName, username, email, phone, password, gender }, { responseType: 'text' });
  }
  
}
