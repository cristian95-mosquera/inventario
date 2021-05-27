import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { ListaMercanciaComponent } from './mercancia/lista-mercancia/lista-mercancia.component';
import { NuevoMercanciaComponent } from './mercancia/nuevo-mercancia/nuevo-mercancia.component';
import { EditarMercanciaComponent } from './mercancia/editar-mercancia/editar-mercancia.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'


//external
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';
import { ListaUsuarioComponent } from './usuario/lista-usuario/lista-usuario.component';
import { ListaCargoComponent } from './cargo/lista-cargo/lista-cargo.component';
import { GuardarCargoComponent } from './cargo/guardar-cargo/guardar-cargo.component';
import { GuardarUsuarioComponent } from './usuario/guardar-usuario/guardar-usuario.component';
import { EliminarUsuarioComponent } from './usuario/eliminar-usuario/eliminar-usuario.component';


@NgModule({
  declarations: [
    AppComponent,
    ListaMercanciaComponent,
    NuevoMercanciaComponent,
    EditarMercanciaComponent,
    ListaUsuarioComponent,
    ListaCargoComponent,
    GuardarCargoComponent,
    GuardarUsuarioComponent,
    EliminarUsuarioComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
