import { Time } from "@angular/common";

export interface Appointments {
   userName: String;
	doctorName: String;
    department: String;
    appointmentDate: Date;
	appointmentTime: Time;
}
