import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UsersComponent} from './users/users.component';
import {AdduserComponent} from './adduser/adduser.component'
import { EditUserComponent } from './edit-user/edit-user.component';
export const routes: Routes = [
  { path: 'users', component: UsersComponent },
  {path:'adduser' , component:AdduserComponent },
  {path: '', redirectTo: '/users', pathMatch: 'full' },
  {path:'edituser' , component:EditUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  
 
 }
