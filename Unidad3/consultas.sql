select apellido1 from empleado;

select distinct apellido1 from empleado;

select nombre, gastos from departamento
order by gastos
limit 2;

select nombre, presupuesto from departamento 
where presupuesto >= 150000;

select e.nombre, d.id, d.nombre
from empleado e, departamento d
where d.id = e.id_departamento;

select e.nombre, e.apellido1, d.id, d.nombre
from empleado e, departamento d
where d.id = e.id_departamento
order by d.nombre, e.apellido1, e.nombre asc;

select d.id, d.nombre 
from departamento d, empleado e
where e.id_departamento = d.id
group by d.id;

select d.nombre
from departamento d, empleado e
where d.id = e.id_departamento
and e.nif = '38382980M';

select sum(presupuesto)
from departamento;



