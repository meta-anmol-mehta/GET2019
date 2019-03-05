import { Injectable } from '@angular/core';
import { User } from './user';
import { users } from './users/users.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  selectedUser:User;
  index:number;

  getUsers(): User[] {
    return users;
  }

  getSelectedUser(): User {
    
    this.index=users.indexOf(this.selectedUser);
    
    return this.selectedUser;

  }

  editSelectedUser(user:User): void {
    
    users.splice(this.index,0,user);

  }

  setSelectedUser(user:User):void{
    this.selectedUser=user;
  }

  insert(user:User):void{

    users.push(user);

  }

}
