import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { MenuComponent } from './components/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { AddTaskComponent } from './components/add-task/add-task.component';
import { ViewTaskComponent } from './components/view-task/view-task.component';
import { EditTaskComponent } from './components/edit-task/edit-task.component';
import { ForgetPasswordComponent } from './components/forget-password/forget-password.component';

const routes: Routes = [
  {
    path:'',component:LoginComponent
  },{
    path:'signup',component:SignupComponent
  },{
    path:'menu',component:MenuComponent
  },{
    path:'home',component:HomeComponent
  },{
    path:'add-task',component:AddTaskComponent
  },{
    path:'view-task',component:ViewTaskComponent
  },{
    path:'forget-password',component:ForgetPasswordComponent
  },{
    path:'edit-task/:id',component:EditTaskComponent
  },{ path: '', redirectTo: '/signup', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
