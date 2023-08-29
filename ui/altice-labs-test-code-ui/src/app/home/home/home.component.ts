import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LabsecService } from 'src/app/service/labsec.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  form: FormGroup = new FormGroup({});
  inputNumber: any;
  labseqGeneratedData: any;
  isLoading: boolean = false;

  constructor(private labsecService: LabsecService, private fb: FormBuilder, private toastr: ToastrService) {

    this.form = this.fb.group({
      inputNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$")]]

    })
  }

  ngOnInit(): void {
  }



  submit() {
    this.isLoading = true;
    let data = this.form.value;
    console.log('Input number:', data.inputNumber);
    this.labsecService.labseqLoad(data.inputNumber).subscribe(resp => {

      this.labseqGeneratedData = resp.data;
      this.toastr.success("Loaded with success", "Success");
      this.isLoading = false;
      this.form.reset();

    }, (error) => {
      this.isLoading = false;
      console.log("data error", error);
      this.labseqGeneratedData = error['error']['message'];
      this.toastr.error("Operation not allowed", "Error");
    });

  }

}
