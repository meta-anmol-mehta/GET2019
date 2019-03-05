import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

selectedUser:User;  

constructor(private userService:UserService) { }



ngOnInit() {

  this.selectedUser=this.userService.getSelectedUser();

}

edit(selectedUser:User):void{

  this.userService.editSelectedUser(selectedUser);

}

}
