import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  private loginUrl = 'http://localhost:8081/user/login-user';

  loginUser(username:string,password:string):Observable<any>{
    const body={username,password}
    return this.http.post<any>(this.loginUrl,body)
  }
  private baseUrl = 'http://localhost:8081/user';
  changePassword(username: string, newPassword: string): Observable<any> {
    return this.http.put<{ message: string }>(`${this.baseUrl}/change-password`, { username, newPassword });
  }
}
