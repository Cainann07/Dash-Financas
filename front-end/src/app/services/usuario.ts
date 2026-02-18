import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

interface DadosLogin{
  email: string,
  senha: string
}

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/usuarios';

  constructor(private http: HttpClient) { }

  inserirUsuario(usuario: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, usuario);
  }

  fazerLogin(dadosLogin: DadosLogin): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, dadosLogin);
  }
}
