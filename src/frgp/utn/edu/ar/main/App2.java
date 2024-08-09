package frgp.utn.edu.ar.main;

import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnosNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

	public static void main(String[] args) {
		
		//Inicializacion beans
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
    	
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
		TurnosNegocio turnoNegocio = (TurnosNegocio) appContext.getBean("beanTurnosNegocio");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
		
		
		//Ejercicio 1
		
    	List<Medico> medicos = medicoNegocio.LeerMayorAMenorLegajo();
    	System.out.println("------- 1. LISTA DE Medicos -------");
    	for (Medico m : medicos) {
        	System.out.println(m.toString());
    	}
    	System.out.println("------- FIN LISTA DE Medicos -------\n");
    	
		
    	//Ejercicio 2
		
    	List<Object[]> medicos2 = medicoNegocio.LeerMenorAMayorLegajo();
    	System.out.println("------- 2. LISTA DE Medicos -------");
    	for (Object[] m : medicos2) {
        	System.out.println("Legajo: "+m[0]+", Nombre: "+m[1]+", Apellido: "+m[2]);
    	}
    	System.out.println("------- FIN LISTA DE Medicos -------\n");
    	
    	
    	//Ejercicio 3
    	///Agregamos Medico con legajo 1234
    	Usuario usuario1 = (Usuario) appContext.getBean("beanUsuario");
    	usuario1.setNombre_usuario("MedicoEj3TP5");
    	usuario1.setContrasenia("1234");
    	usuario1.setEstado(true);
    	
		Medico medico1 = (Medico) appContext.getBean("beanMedico");
    	medico1.setLegajo(1234);
    	medico1.setNombre("Julio");
    	medico1.setApellido("Juarez");
    	medico1.setFechaNacimiento("04/09/1999");
    	medico1.setEmail("JULIO.Juarez@gmail.com");
    	medico1.setSexo('M');
    	medico1.setLocalidad("Don Torcuato");
    	medico1.setDireccion("Juan de Garay 1701");
    	medico1.setTelefono(1166995454);
    	medico1.setEstado(true);
    	medico1.setUsuario(usuario1);
    	medico1.setDiasQueTrabaja("Lunes,Martes,Jueves,Viernes");
    	medico1.setHoraEntrada("12:00");
    	medico1.setHoraSalida("18:00");
    	
		Especialidad especialidadMedico1 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidadMedico1.setId(10);
    	especialidadMedico1.setNombre("Otorrinolaringologia");
    	especialidadMedico1.setEstado(true);
    	medico1.setEspecialidad(especialidadMedico1);
    	
    	
    	usuarioNegocio.Add(usuario1);
    	medicoNegocio.Add(medico1);
    	
    	///Agregamos algunos turnos
    	Turno turnos = (Turno) appContext.getBean("beanTurno");

    	
		Medico medicoTurnos1 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos1 = medicoNegocio.ReadOne(1234);
    	Paciente pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215370);
    	
    	turnos.setMedico(medicoTurnos1);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("02/01/2025");
    	turnos.setHora("17:00");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Presente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos2 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos2 = medicoNegocio.ReadOne(1234);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215368);
    	
    	turnos.setMedico(medicoTurnos2);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("04/02/2025");
    	turnos.setHora("14:15");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Pendiente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos3 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos3 = medicoNegocio.ReadOne(1234);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215363);
    	
    	turnos.setMedico(medicoTurnos3);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("02/01/2025");
    	turnos.setHora("12:30");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Ausente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos4 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos4 = medicoNegocio.ReadOne(1234);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215365);
    	
    	turnos.setMedico(medicoTurnos4);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("01/04/2025");
    	turnos.setHora("13:45");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Pendiente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos5 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos5 = medicoNegocio.ReadOne(1234);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215366);
    	
    	turnos.setMedico(medicoTurnos5);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("02/01/2025");
    	turnos.setHora("15:00");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Pendiente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos6 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos6 = medicoNegocio.ReadOne(1234);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215365);
    	
    	turnos.setMedico(medicoTurnos6);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("04/02/2024");
    	turnos.setHora("12:45");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Presente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
		
		//Ejercicio 3
    	System.out.println("------- 3. MOSTRAR turnos de Medico 1234 del 01/01/2025 -------\n");
		medicoNegocio.ReadInnerJoinTurnos(1234, "01/01/2025");

		//Ejercicio 4
		
		medicoNegocio.Leer_ColumnaLegajo();
		
		
		//Ejercicio 5
		System.out.println("------- 5. -------\n");
		medicoNegocio.LeerMayorLegajo();
		
		
		//Ejercicio 6
		//turnoNegocio.MostrarPorcentajeTurnos();
		
		
	}

}
