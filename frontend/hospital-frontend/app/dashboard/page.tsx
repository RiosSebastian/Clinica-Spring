import PatientsChart from '@/components/charts/PatientsChart'

import {
  Users,
  CalendarDays,
  BedDouble,
  FileText,
} from 'lucide-react'

const cards = [
  {
    title: 'Pacientes',
    value: '120',
    icon: Users,
  },
  {
    title: 'Turnos',
    value: '58',
    icon: CalendarDays,
  },
  {
    title: 'Camas',
    value: '30',
    icon: BedDouble,
  },
  {
    title: 'Análisis',
    value: '87',
    icon: FileText,
  },
]

export default function DashboardPage() {
  return (
    <div className="space-y-8">
      <h1 className="text-3xl font-bold text-zinc-800">
        Dashboard Médico
      </h1>

      {/* CARDS */}
      <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-4 gap-6">
        {cards.map((card) => {
          const Icon = card.icon

          return (
            <div
              key={card.title}
              className="bg-white border border-emerald-100 rounded-3xl p-6 shadow-sm hover:shadow-md transition"
            >
              <div className="flex items-center justify-between mb-4">
                <h2 className="text-zinc-500 font-medium">
                  {card.title}
                </h2>

                <Icon className="text-emerald-500" />
              </div>

              <p className="text-4xl font-bold text-zinc-800">
                {card.value}
              </p>
            </div>
          )
        })}
      </div>

      {/* CHART */}
      <PatientsChart />
    </div>
  )
}