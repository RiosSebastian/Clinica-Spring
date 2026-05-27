'use client'

import {
  ResponsiveContainer,
  LineChart,
  Line,
  XAxis,
  Tooltip,
  CartesianGrid,
} from 'recharts'

const data = [
  {
    mes: 'Ene',
    pacientes: 40,
  },
  {
    mes: 'Feb',
    pacientes: 55,
  },
  {
    mes: 'Mar',
    pacientes: 70,
  },
  {
    mes: 'Abr',
    pacientes: 90,
  },
  {
    mes: 'May',
    pacientes: 120,
  },
]

export default function PatientsChart() {
  return (
    <div className="bg-white border border-emerald-100 rounded-3xl p-6 shadow-sm">
      <div className="mb-6">
        <h2 className="text-xl font-bold text-zinc-800">
          Ingreso de Pacientes
        </h2>

        <p className="text-zinc-500 text-sm">
          Estadísticas mensuales
        </p>
      </div>

      <div className="h-[350px]">
        <ResponsiveContainer width="100%" height="100%">
          <LineChart data={data}>
            <CartesianGrid strokeDasharray="3 3" />

            <XAxis dataKey="mes" />

            <Tooltip />

            <Line
              type="monotone"
              dataKey="pacientes"
              stroke="#10b981"
              strokeWidth={4}
            />
          </LineChart>
        </ResponsiveContainer>
      </div>
    </div>
  )
}