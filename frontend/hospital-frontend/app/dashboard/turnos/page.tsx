'use client'

import DataTable from '@/components/tables/DataTable'

const data = [
  {
    paciente: 'Juan Pérez',
    doctor: 'Dr. Gómez',
    fecha: '2026-05-20',
    estado: 'RESERVADO',
  },
]

export default function TurnosPage() {
  const columns = [
    {
      key: 'paciente',
      label: 'Paciente',
    },
    {
      key: 'doctor',
      label: 'Doctor',
    },
    {
      key: 'fecha',
      label: 'Fecha',
    },
    {
      key: 'estado',
      label: 'Estado',
    },
  ]

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold text-zinc-800">
          Turnos
        </h1>

        <button className="bg-emerald-500 hover:bg-emerald-600 text-white px-5 py-3 rounded-2xl font-semibold shadow-sm transition">
          Nuevo Turno
        </button>
      </div>

      <DataTable columns={columns} data={data} />
    </div>
  )
}