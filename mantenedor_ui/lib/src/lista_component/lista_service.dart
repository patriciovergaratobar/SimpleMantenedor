import 'dart:async';

import 'package:angular/core.dart';

@Injectable()
class ListaService {

  List<String> mockTodoList = <String>[];

  Future<List<String>> getTodoList() async => mockTodoList;
}
