import Link from 'next/link'

import {
  Activity,
  HeartPulse,
  Brain,
  Baby,
  Bone,
} from 'lucide-react'

const especialidades = [
  {
    title: 'Cardiología',
    icon: HeartPulse,
  },
  {
    title: 'Neurología',
    icon: Brain,
  },
  {
    title: 'Pediatría',
    icon: Baby,
  },
  {
    title: 'Traumatología',
    icon: Bone,
  },
]

export default function HomePage() {
  return (
    <div className="min-h-screen bg-[#f4fdf9]">
      {/* HEADER */}
      <header className="bg-white border-b border-emerald-100 sticky top-0 z-50">
        <div className="max-w-7xl mx-auto h-20 px-6 flex items-center justify-between">
          <div className="flex items-center gap-3">
            <div className="w-12 h-12 rounded-2xl bg-emerald-500 flex items-center justify-center">
              <Activity className="text-white" />
            </div>

            <div>
              <h1 className="font-bold text-xl text-zinc-800">
                Hospital Central
              </h1>

              <p className="text-sm text-zinc-500">
                Salud y tecnología
              </p>
            </div>
          </div>

          <div className="flex items-center gap-4">
            <Link
              href="/login"
              className="text-emerald-600 font-semibold"
            >
              Iniciar sesión
            </Link>

            <button className="bg-emerald-500 hover:bg-emerald-600 text-white px-5 py-3 rounded-2xl font-semibold">
              Reservar turno
            </button>
          </div>
        </div>
      </header>

      {/* HERO */}
      <section className="max-w-7xl mx-auto px-6 py-24">
        <div className="grid lg:grid-cols-2 gap-16 items-center">
          <div>
            <div className="inline-flex items-center gap-2 bg-emerald-100 text-emerald-700 px-4 py-2 rounded-full text-sm font-semibold mb-6">
              <Activity size={18} />
              Plataforma médica moderna
            </div>

            <h1 className="text-6xl font-bold leading-tight text-zinc-800">
              Tu salud conectada con la mejor atención médica
            </h1>

            <p className="mt-8 text-xl text-zinc-600 leading-relaxed">
              Gestioná turnos, consultá análisis y accedé
              a profesionales médicos desde cualquier lugar.
            </p>

            <div className="flex gap-4 mt-10">
              <button className="bg-emerald-500 hover:bg-emerald-600 text-white px-7 py-4 rounded-2xl font-semibold shadow-lg">
                Sacar turno
              </button>

              <Link
                href="/login"
                className="bg-white border border-emerald-100 hover:bg-emerald-50 px-7 py-4 rounded-2xl font-semibold"
              >
                Acceder al sistema
              </Link>
            </div>
          </div>

          {/* CARD */}
          <div className="bg-white border border-emerald-100 rounded-[40px] p-10 shadow-xl">
            <div className="grid grid-cols-2 gap-6">
              {especialidades.map((especialidad) => {
                const Icon = especialidad.icon

                return (
                  <div
                    key={especialidad.title}
                    className="bg-emerald-50 rounded-3xl p-6"
                  >
                    <div className="w-14 h-14 rounded-2xl bg-white flex items-center justify-center mb-4 shadow-sm">
                      <Icon className="text-emerald-600" />
                    </div>

                    <h3 className="font-bold text-zinc-800 text-lg">
                      {especialidad.title}
                    </h3>
                  </div>
                )
              })}
            </div>
          </div>
        </div>
      </section>
    </div>
  )
}