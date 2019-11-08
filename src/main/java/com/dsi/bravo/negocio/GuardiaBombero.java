package com.dsi.bravo.negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:47 PM
 */
public class GuardiaBombero {

	private LocalDateTime horaDesde;
	private LocalDateTime horaHasta;
	private String motivoRechazo;
	private Bombero bombero;
	private LocalDateTime diaSemana;
	private DetencionGuardia detencionGuardia;
	private Estado estado;
	private TipoGuardia tipoGuardia;
	private DetalleGuardiaBombero detalleGuardiaBombero;

	public GuardiaBombero(){

	}

	public LocalDateTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalDateTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public LocalDateTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalDateTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public Bombero getBombero() {
		return bombero;
	}

	public void setBombero(Bombero bombero) {
		this.bombero = bombero;
	}

	public LocalDateTime getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(LocalDateTime diaSemana) {
		this.diaSemana = diaSemana;
	}

	public DetencionGuardia getDetencionGuardia() {
		return detencionGuardia;
	}

	public void setDetencionGuardia(DetencionGuardia detencionGuardia) {
		this.detencionGuardia = detencionGuardia;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoGuardia getTipoGuardia() {
		return tipoGuardia;
	}

	public void setTipoGuardia(TipoGuardia tipoGuardia) {
		this.tipoGuardia = tipoGuardia;
	}

	public DetalleGuardiaBombero getDetalleGuardiaBombero() {
		return detalleGuardiaBombero;
	}

	public void setDetalleGuardiaBombero(DetalleGuardiaBombero detalleGuardiaBombero) {
		this.detalleGuardiaBombero = detalleGuardiaBombero;
	}

	public void finalize() throws Throwable {

	}
	public void cancelar(){

	}

	public void confirmar(){

	}

	public void controlar(){

	}

	public void detener(){

	}

	public void esDeBombero(){

	}

	public void esEstadoEnCurso(){

	}

	public void finalizar(){

	}

	public void iniciar(){

	}

	public String mostrarDatos(){
		return null;
	}

	public void reanudar(){

	}

	public void rechazar(){

	}

	public void validar(){

	}
}//end GuardiaBombero