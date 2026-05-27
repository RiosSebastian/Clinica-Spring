'use client'

import DataTable from '@/components/tables/DataTable'

const data = [
  {
    nombre: 'Juan',
    apellido: 'Pérez',
    email: 'juan@gmail.com',
    telefono: '3435123456',
  },
]

export default function PacientesPage() {
  const columns = [
    {
      key: 'nombre',
      label: 'Nombre',
    },
    {
      key: 'apellido',
      label: 'Apellido',
    },
    {
      key: 'email',
      label: 'Email',
    },
    {
      key: 'telefono',
      label: 'Teléfono',
    },
  ]

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold text-zinc-800">
          Pacientes
        </h1>

        <button className="bg-emerald-500 hover:bg-emerald-600 text-white px-5 py-3 rounded-2xl font-semibold shadow-sm transition">
          Nuevo Paciente
        </button>
      </div>

      <DataTable columns={columns} data={data} />
    </div>
  )
}