import { Component, OnInit } from '@angular/core';
import { Mercancia } from 'src/app/models/mercancia';
import { MercanciaService } from 'src/app/service/mercancia.service';

@Component({
  selector: 'app-lista-mercancia',
  templateUrl: './lista-mercancia.component.html',
  styleUrls: ['./lista-mercancia.component.css']
})
export class ListaMercanciaComponent implements OnInit {

  mercancia: Mercancia[] = [];

  constructor(private mercanciaService: MercanciaService) { }

  ngOnInit() {
    this.cargarLista();
    
  }

  cargarLista(): void{
    this.mercanciaService.listar().subscribe(
      data => {
        this.mercancia = data;
      },
      err => {
        console.log(err);
      }
    ) 
  }


}
