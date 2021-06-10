import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Usuario } from 'src/app/models/usuario';
import { MercanciaService } from 'src/app/service/mercancia.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-editar-mercancia',
  templateUrl: './editar-mercancia.component.html',
  styleUrls: ['./editar-mercancia.component.css']
})
export class EditarMercanciaComponent implements OnInit {

  usuarios: Usuario[] = [];
  
  editarMercancia: FormGroup;
  constructor(private mercanciaService: MercanciaService ,private usuarioService: UsuarioService, private formBuilder: FormBuilder, private toastr: ToastrService, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editarMercancia = this.formBuilder.group({
      nombreProducto: ['', Validators.required],
      cantidad: ['', Validators.required],
      fechaIngreso: ['', Validators.required],
      usuario: ['', Validators.required],
    });
    this.listarUsuario();
    
  }

  listarUsuario(){
    this.usuarioService.listarUsuario().subscribe((listarUsuario) => this.usuarios = listarUsuario);
  }

  actualizarMercancia() {
    
    let id =+this.route.snapshot.paramMap.get('id');
    if(this.editarMercancia.valid){
      this.mercanciaService.editar(id,this.editarMercancia.value).subscribe(
       data => {
        this.toastr.success('Mercancia actualizada con exito', 'información');
       },
       (error:any)=> {
        this.toastr.error(error.error?.mensaje,'Error'); 
       }
      )
    }
  }

}
