'use client'

import DataTable from '@/components/tables/DataTable'

const data = [
  {
    numero: 'A-12',
    estado: 'DISPONIBLE',
    gravedad: 'LEVE',
  },
  {
    numero: 'B-03',
    estado: 'OCUPADA',
    gravedad: 'ALTA',
  },
]

export default function CamasPage() {
  const columns = [
    {
      key: 'numero',
      label: 'Número',
    },
    {
      key: 'estado',
      label: 'Estado',
    },
    {
      key: 'gravedad',
      label: 'Gravedad',
    },
  ]

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold text-zinc-800">
          Camas
        </h1>

        <button className="bg-emerald-500 hover:bg-emerald-600 text-white px-5 py-3 rounded-2xl font-semibold shadow-sm transition">
          Nueva Cama
        </button>
      </div>

      <DataTable columns={columns} data={data} />
    </div>
  )
}