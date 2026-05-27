import Link from 'next/link'
import {
  HeartPulse,
  Stethoscope,
  Brain,
  Baby,
  Bone,
  Clock3,
  ShieldCheck,
  FileText,
  CalendarCheck,
  Activity,
} from 'lucide-react'

const especialidades = [
  {
    title: 'Cardiología',
    icon: HeartPulse,
  },
  {
    title: 'Pediatría',
    icon: Baby,
  },
  {
    title: 'Neurología',
    icon: Brain,
  },
  {
    title: 'Traumatología',
    icon: Bone,
  },
  {
    title: 'Clínica Médica',
    icon: Stethoscope,
  },
]

const beneficios = [
  {
    title: 'Atención 24hs',
    description:
      'Profesionales disponibles las 24 horas para emergencias y consultas.',
    icon: Clock3,
  },
  {
    title: 'Resultados Online',
    description:
      'Consultá análisis y estudios desde cualquier dispositivo.',
    icon: FileText,
  },
  {
    title: 'Turnos Rápidos',
    description:
      'Reservá turnos médicos fácilmente y sin esperas.',
    icon: CalendarCheck,
  },
  {
    title: 'Seguridad Médica',
    description:
      'Protección total de datos clínicos y privacidad.',
    icon: ShieldCheck,
  },
]

export default function HomePage() {
  return (
    <div className="min-h-screen bg-[#f4fdf9]">
      {/* HEADER */}
      <header className="w-full bg-white border-b border-emerald-100 sticky top-0 z-50">
        <div className="max-w-7xl mx-auto px-6 h-20 flex items-center justify-between">
          {/* LOGO */}
          <div className="flex items-center gap-3">
            <div className="w-12 h-12 rounded-2xl bg-emerald-500 flex items-center justify-center shadow-md">
              <Activity className="text-white" />
            </div>

            <div>
              <h1 className="text-xl font-bold text-zinc-800">
                Hospital Central
              </h1>

              <p className="text-sm text-zinc-500">
                Salud y tecnología
              </p>
            </div>
          </div>

          {/* NAV */}
          <nav className="hidden md:flex items-center gap-8 text-zinc-600 font-medium">
            <a
              href="#especialidades"
              className="hover:text-emerald-600 transition"
            >
              Especialidades
            </a>

            <a
              href="#beneficios"
              className="hover:text-emerald-600 transition"
            >
              Beneficios
            </a>

            <a
              href="#contacto"
              className="hover:text-emerald-600 transition"
            >
              Contacto
            </a>
          </nav>

          {/* BUTTONS */}
          <div className="flex items-center gap-4">
            <Link
              href="/login"
              className="
                text-emerald-600
                font-semibold
                hover:text-emerald-700
                transition
              "
            >
              Iniciar sesión
            </Link>

            <button
              className="
                bg-emerald-500
                hover:bg-emerald-600
                text-white
                px-5
                py-3
                rounded-2xl
                font-semibold
                shadow-sm
                transition
              "
            >
              Reservar turno
            </button>
          </div>
        </div>
      </header>

      {/* HERO */}
      <section className="max-w-7xl mx-auto px-6 py-24">
        <div className="grid lg:grid-cols-2 gap-16 items-center">
          {/* LEFT */}
          <div>
            <div className="inline-flex items-center gap-2 bg-emerald-100 text-emerald-700 px-4 py-2 rounded-full text-sm font-semibold mb-6">
              <Activity size={18} />
              Plataforma médica moderna
            </div>

            <h1 className="text-5xl lg:text-6xl font-bold leading-tight text-zinc-800">
              Cuidamos tu salud con tecnología y atención humana
            </h1>

            <p className="mt-8 text-xl text-zinc-600 leading-relaxed">
              Gestioná turnos médicos, consultá análisis clínicos y accedé
              a atención profesional desde una plataforma simple y segura.
            </p>

            <div className="flex flex-wrap gap-4 mt-10">
              <button
                className="
                  bg-emerald-500
                  hover:bg-emerald-600
                  text-white
                  px-7
                  py-4
                  rounded-2xl
                  font-semibold
                  shadow-lg
                  transition
                "
              >
                Sacar turno
              </button>

              <Link
                href="/login"
                className="
                  bg-white
                  border
                  border-emerald-100
                  hover:bg-emerald-50
                  text-zinc-700
                  px-7
                  py-4
                  rounded-2xl
                  font-semibold
                  transition
                "
              >
                Acceder al sistema
              </Link>
            </div>
          </div>

          {/* RIGHT */}
          <div
            className="
              bg-white
              border
              border-emerald-100
              rounded-[40px]
              p-10
              shadow-xl
            "
          >
            <div className="grid grid-cols-2 gap-6">
              {beneficios.map((beneficio) => {
                const Icon = beneficio.icon

                return (
                  <div
                    key={beneficio.title}
                    className="
                      bg-emerald-50
                      rounded-3xl
                      p-6
                    "
                  >
                    <div className="w-14 h-14 rounded-2xl bg-white flex items-center justify-center mb-4 shadow-sm">
                      <Icon className="text-emerald-600" />
                    </div>

                    <h3 className="font-bold text-zinc-800 text-lg mb-2">
                      {beneficio.title}
                    </h3>

                    <p className="text-zinc-600 text-sm leading-relaxed">
                      {beneficio.description}
                    </p>
                  </div>
                )
              })}
            </div>
          </div>
        </div>
      </section>

      {/* ESPECIALIDADES */}
      <section
        id="especialidades"
        className="py-24 bg-white border-y border-emerald-100"
      >
        <div className="max-w-7xl mx-auto px-6">
          <div className="text-center mb-16">
            <h2 className="text-4xl font-bold text-zinc-800 mb-4">
              Especialidades Médicas
            </h2>

            <p className="text-zinc-600 text-lg">
              Profesionales especializados en distintas áreas de la salud
            </p>
          </div>

          <div className="grid sm:grid-cols-2 lg:grid-cols-5 gap-6">
            {especialidades.map((especialidad) => {
              const Icon = especialidad.icon

              return (
                <div
                  key={especialidad.title}
                  className="
                    bg-[#f4fdf9]
                    border
                    border-emerald-100
                    rounded-3xl
                    p-8
                    text-center
                    hover:shadow-lg
                    hover:-translate-y-1
                    transition
                  "
                >
                  <div className="w-16 h-16 rounded-2xl bg-emerald-500 flex items-center justify-center mx-auto mb-5 shadow-md">
                    <Icon className="text-white" />
                  </div>

                  <h3 className="font-bold text-zinc-800 text-lg">
                    {especialidad.title}
                  </h3>
                </div>
              )
            })}
          </div>
        </div>
      </section>

      {/* FOOTER */}
      <footer
        id="contacto"
        className="bg-white py-10 border-t border-emerald-100"
      >
        <div className="max-w-7xl mx-auto px-6 flex flex-col md:flex-row items-center justify-between gap-6">
          <div>
            <h3 className="text-xl font-bold text-zinc-800">
              Hospital Central
            </h3>

            <p className="text-zinc-500 mt-2">
              Plataforma médica moderna y segura
            </p>
          </div>

          <div className="flex items-center gap-6 text-zinc-500">
            <span>© 2026</span>
            <span>Privacidad</span>
            <span>Términos</span>
          </div>
        </div>
      </footer>
    </div>
  )
}