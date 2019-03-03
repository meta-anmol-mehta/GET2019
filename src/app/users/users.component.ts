import { Component, OnInit } from '@angular/core';
import { User } from '../user'
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users:User[]=[
    {name:"Akshat",contact:123456,place:"Jaipur"},
    {name:"Shubham",contact:123456,place:"Mumbai"},
    {name:"Rahul",contact:123456,place:"Delhi"},
    {name:"Nitesh",contact:123456,place:"Jaipur"},
    {name:"Joy",contact:123456,place:"Ahmdabad"},
    {name:"Java",contact:123456,place:"Kolkata"}
  ];

  constructor() { }

  selectedUser: User;
  onSelect(user: User): void {
    this.selectedUser = user;
  }

  ngOnInit() {
  }

}
