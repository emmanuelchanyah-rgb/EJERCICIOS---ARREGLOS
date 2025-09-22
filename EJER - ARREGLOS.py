
meses = [
    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
]
departamentos = ["Ropa", "Deportes", "Juguetería"]
ventas = [[0 for _ in departamentos] for _ in meses]

def parse_mes(inp):
    s = inp.strip().lower()
   
    if s.isdigit():
        i = int(s) - 1
        if 0 <= i < len(meses):
            return i
        return None
    
    for i, m in enumerate(meses):
        if m.lower() == s:
            return i

    if len(s) >= 2:
        pref = s[:3]
        for i, m in enumerate(meses):
            if m.lower().startswith(pref):
                return i
    return None
def parse_depto(inp):
    s = inp.strip().lower()
    
    if s.isdigit():
        j = int(s) - 1
        if 0 <= j < len(departamentos):
            return j
        return None
   
    for j, d in enumerate(departamentos):
        if d.lower() == s:
            return j
    
    if len(s) >= 2:
        pref = s[:3]
        for j, d in enumerate(departamentos):
            if d.lower().startswith(pref):
                return j
    return None
def insertar_venta():
    print("\n-> Insertar venta")
    print("Escribe el mes (número 1-12 o nombre/abreviatura). Eje: 2 o feb")
    mes_in = input("Mes: ")
    i = parse_mes(mes_in)
    if i is None:
        print("Mes no válido. Intenta de nuevo.")
        return
    print("Departamentos: 1-Ropa  2-Deportes  3-Juguetería")
    depto_in = input("Departamento (número o nombre): ")
    j = parse_depto(depto_in)
    if j is None:
        print("Departamento no válido. Intenta de nuevo.")
        return
    try:
        monto = float(input("Ingresa el monto de la venta (eje. 1500): "))
    except ValueError:
        print("Monto no válido. Debe ser un número.")
        return
    ventas[i][j] = monto  
    print(f" Guardado: {meses[i]} - {departamentos[j]} = {monto}")
def buscar_venta():
    print("\n Buscar venta")
    mes_in = input("Mes (número o nombre): ")
    i = parse_mes(mes_in)
    if i is None:
        print("Mes no válido.")
        return
    depto_in = input("Departamento (número o nombre): ")
    j = parse_depto(depto_in)
    if j is None:
        print("Departamento no válido.")
        return
    print(f" Resultado: {meses[i]} - {departamentos[j]} = {ventas[i][j]}")
def eliminar_venta():
    print("\n-> Eliminar venta")
    mes_in = input("Mes (número): ")
    i = parse_mes(mes_in)
    if i is None:
        print("Mes no válido.")
        return
    depto_in = input("Departamento (número): ")
    j = parse_depto(depto_in)
    if j is None:
        print("Departamento no válido.")
        return
    ventas[i][j] = 0
    print(f" Eliminado: {meses[i]} - {departamentos[j]}")
def mostrar_ventas():
    print("\n Ventas actuales:")
    header = f"{'Mes':<12}" + "".join(f"{d:<12}" for d in departamentos)
    print(header)
    for i, mes in enumerate(meses):
        fila = f"{mes:<12}" + "".join(f"{ventas[i][j]:<12}" for j in range(len(departamentos)))
        print(fila)
def menu():
    while True:
        print("\n MENÚ ")
        print("1) Insertar venta")
        print("2) Buscar venta")
        print("3) Eliminar venta")
        print("4) Mostrar todas las ventas")
        print("5) Salir")
        opc = input("Elige una opción (1-5): ").strip()
        if opc == "1":
            insertar_venta()
        elif opc == "2":
            buscar_venta()
        elif opc == "3":
            eliminar_venta()
        elif opc == "4":
            mostrar_ventas()
        elif opc == "5":
            print("saliendo.")
            break
        else:
            print("Opción inválida. Escribe 1, 2, 3, 4 o 5.")

if __name__ == "__main__":
    menu()
