import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GastoMensalRequest } from '../pages/model/gasto-mensal-request.model';
import { GastoMensalResponse } from '../pages/model/gasto-mensal-response.model';


@Injectable({
    providedIn: 'root',
})

export class GastoMensalService {
    private apiUrl = 'http://localhost:8080/gastos';

    constructor(private http: HttpClient) { }

    inserirGasto(idUsuario : number, gasto: GastoMensalRequest): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/${idUsuario}`, gasto);
    }

    listarGastos(idUsuario: number): Observable<GastoMensalResponse[]> {
        return this.http.get<GastoMensalResponse[]>(`${this.apiUrl}/${idUsuario}`);
    }

    atualizarGasto(id: number, gasto: GastoMensalRequest): Observable<GastoMensalResponse> {
        return this.http.put<GastoMensalResponse>(`${this.apiUrl}/${id}`, gasto);
    }

    deletarGasto(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }


}
