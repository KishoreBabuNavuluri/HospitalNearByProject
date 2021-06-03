import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  loginForm: any;
  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm=new FormGroup({
      password: new FormControl(null, Validators.required), 
      name: new FormControl(null, Validators.required) //Note we can add more than one validator, if we have email we can add validator for the email.
    });
  }

  message:any;
  success:any;
  onSubmit(): void {
    console.log(this.loginForm.value);
    this.adminService.isValidAdmin(this.loginForm.value).subscribe(data=>{
        if(data==null) {
          this.message="Invalid Credentials";
          this.success="";
        }
        else {
          this.message="";
          localStorage.setItem("adminName", data.name);
          this.success=localStorage.getItem("userName")+" is valid user";
          console.log(data);
          this.router.navigate(['/adminselectspecialization']);
          
        }
    });
  }

}
