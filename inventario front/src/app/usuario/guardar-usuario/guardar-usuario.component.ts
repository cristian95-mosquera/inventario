import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Cargo } from 'src/app/models/cargo';
import { Usuario } from 'src/app/models/usuario';
import { CargoService } from 'src/app/service/cargo.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-guardar-usuario',
  templateUrl: './guardar-usuario.component.html',
  styleUrls: ['./guardar-usuario.component.css']
})
export class GuardarUsuarioComponent implements OnInit {


  cargos: Cargo[] = [];

  formularioUsuario: FormGroup;

 
  constructor(private formBuilder: FormBuilder, private toastr: ToastrService, private usuarioService: UsuarioService, private cargoService: CargoService) {}

  ngOnInit(): void {
    this.formularioUsuario = this.formBuilder.group({
      nombre: ['', Validators.required],
      edad: ['', Validators.required],
      fechaIngresoCompaia: ['', Validators.required],
      idCargo: ['', Validators.required],
    });
    this.listarCargos();
    
  }

  guardarUsuario() {
    if(this.formularioUsuario.valid){
      this.usuarioService.guardarUsuario(this.formularioUsuario.value).subscribe(
       ( )=> {
        this.toastr.success('información', 'El usurario se creo exitosamente');
       },
       (error:any)=> {
        this.toastr.error(error.error?.mensaje,'Error'); 
       }
      )
    }
  }

  
  listarCargos():void{
    this.cargoService.listarCargo().subscribe(
      data => {
        this.cargos = data;
      },
      err => {
        this.toastr.error('Error', err?.mensaje);
      }
    )
  }
 
}
