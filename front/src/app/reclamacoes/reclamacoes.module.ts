import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReclamacoesRoutingModule } from './reclamacoes-routing.module';
import { ReclamacoesComponent } from './reclamacoes/reclamacoes.component';


@NgModule({
  declarations: [
    ReclamacoesComponent
  ],
  imports: [
    CommonModule,
    ReclamacoesRoutingModule
  ]
})
export class ReclamacoesModule { }
