'use client'

import Link from 'next/link'
import { usePathname } from 'next/navigation'

import {
  LayoutDashboard,
  Users,
  CalendarDays,
  BedDouble,
  FileText,
  Activity,
  LogOut,
} from 'lucide-react'

const links = [
  {
    name: 'Dashboard',
    href: '/dashboard',
    icon: LayoutDashboard,
  },
  {
    name: 'Pacientes',
    href: '/dashboard/pacientes',
    icon: Users,
  },
  {
    name: 'Turnos',
    href: '/dashboard/turnos',
    icon: CalendarDays,
  },
  {
    name: 'Camas',
    href: '/dashboard/camas',
    icon: BedDouble,
  },
  {
    name: 'Análisis',
    href: '/dashboard/analisis',
    icon: FileText,
  },
]

export default function Sidebar() {
  const pathname = usePathname()

  return (
    <aside className="w-72 min-h-screen bg-white border-r border-emerald-100 flex flex-col justify-between p-6">
      <div>
        {/* LOGO */}
        <div className="flex items-center gap-3 mb-10">
          <div className="w-12 h-12 rounded-2xl bg-emerald-500 flex items-center justify-center shadow-md">
            <Activity className="text-white" size={24} />
          </div>

          <div>
            <h1 className="text-xl font-bold text-zinc-800">
              Hospital Central
            </h1>

            <p className="text-sm text-zinc-500">
              Panel Médico
            </p>
          </div>
        </div>

        {/* LINKS */}
        <nav className="space-y-2">
          {links.map((link) => {
            const Icon = link.icon

            const isActive =
              pathname === link.href

            return (
              <Link
                key={link.href}
                href={link.href}
                className={`
                  flex items-center gap-4 px-4 py-3 rounded-2xl transition-all
                  ${
                    isActive
                      ? 'bg-emerald-50 text-emerald-600 shadow-sm'
                      : 'text-zinc-600 hover:bg-emerald-50 hover:text-emerald-600'
                  }
                `}
              >
                <Icon size={22} />

                <span className="font-medium">
                  {link.name}
                </span>
              </Link>
            )
          })}
        </nav>
      </div>

      {/* USER */}
      <div className="border-t border-emerald-100 pt-6">
        <div className="flex items-center gap-3 mb-4">
          <div className="w-11 h-11 rounded-full bg-emerald-100 flex items-center justify-center text-emerald-700 font-bold">
            DR
          </div>

          <div>
            <p className="font-semibold text-zinc-800">
              Dr. Admin
            </p>

            <p className="text-sm text-zinc-500">
              Administrador
            </p>
          </div>
        </div>

        <button className="w-full flex items-center justify-center gap-2 bg-emerald-500 hover:bg-emerald-600 text-white py-3 rounded-2xl font-medium shadow-sm transition">
          <LogOut size={18} />
          Cerrar sesión
        </button>
      </div>
    </aside>
  )
}