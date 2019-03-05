import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  
  users:User[];


  constructor(private userService:UserService) { }

  
  onSelect(user: User): void {
    
    this.userService.setSelectedUser(user);

  }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(): void {
    this.users = this.userService.getUsers();
  }



}


export const users:User[]=[
  {name:"Akshat",contact:123456,place:"Jaipur"},
  {name:"Shubham",contact:123456,place:"Mumbai"},
  {name:"Rahul",contact:123456,place:"Delhi"},
  {name:"Nitesh",contact:123456,place:"Jaipur"},
  {name:"Joy",contact:123456,place:"Ahmdabad"},
  {name:"Java",contact:123456,place:"Kolkata"}
];
