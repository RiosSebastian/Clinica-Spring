'use client'

import DataTable from '@/components/tables/DataTable'

const data = [
  {
    tipo: 'Sangre',
    fecha: '2026-05-20',
    archivo: 'resultado.pdf',
  },
  {
    tipo: 'Radiografía',
    fecha: '2026-05-18',
    archivo: 'rx.pdf',
  },
]

export default function AnalisisPage() {
  const columns = [
    {
      key: 'tipo',
      label: 'Tipo',
    },
    {
      key: 'fecha',
      label: 'Fecha',
    },
    {
      key: 'archivo',
      label: 'Archivo',
    },
  ]

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-bold text-zinc-800">
          Análisis Clínicos
        </h1>

        <button className="bg-emerald-500 hover:bg-emerald-600 text-white px-5 py-3 rounded-2xl font-semibold shadow-sm transition">
          Subir análisis
        </button>
      </div>

      <DataTable columns={columns} data={data} />
    </div>
  )
}