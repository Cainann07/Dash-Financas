export interface GastoMensalRequest {
  nome: string;
  valor: number;
  diaVencimento: number;
  dataUltimoPagamento: string; // No Angular, datas que vão pro Java vão como string no formato 'YYYY-MM-DD'
}