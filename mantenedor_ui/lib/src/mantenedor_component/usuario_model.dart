class UsuarioModel {

  int usuarioId;
  String rut;
  String nombre;
  String correo;
  String clave;
  String fechaNacimiento;


  UsuarioModel(this.usuarioId, this.rut, this.nombre, this.correo, this.clave, this.fechaNacimiento);

  factory UsuarioModel.fromJson(Map<String, dynamic> usuario) =>
      new UsuarioModel(_toInt(usuario['usuarioId']), usuario['rut'], usuario['nombre'], usuario['correo'], usuario['clave'], usuario['fechaNacimiento']);

  Map toJson() => {'usuarioId': usuarioId, 'rut': rut, 'nombre': nombre, 'correo': correo, 'clave': clave, 'fechaNacimiento': fechaNacimiento};

  @override
  String toString() => 'usuarioId: $usuarioId, rut: $rut, nombre: $nombre, correo: $correo, clave: $clave, fechaNacimiento: $fechaNacimiento';
}

int _toInt(id) => id is int ? id : int.parse(id);