'use client'

import {
  Bell,
  Search,
  Settings,
} from 'lucide-react'

export default function Navbar() {
  return (
    <header
      className="
        h-20
        bg-white/80
        backdrop-blur-xl
        border-b
        border-emerald-100
        px-8
        flex
        items-center
        justify-between
        sticky
        top-0
        z-50
      "
    >
      {/* LEFT */}
      <div>
        <h1 className="text-2xl font-bold text-zinc-800">
          Panel Hospitalario
        </h1>

        <p className="text-sm text-zinc-500">
          Gestión médica y administrativa
        </p>
      </div>

      {/* RIGHT */}
      <div className="flex items-center gap-4">
        {/* SEARCH */}
        <div className="relative hidden md:flex">
          <Search
            size={18}
            className="absolute left-4 top-1/2 -translate-y-1/2 text-zinc-400"
          />

          <input
            type="text"
            placeholder="Buscar pacientes, turnos..."
            className="
              w-80
              bg-emerald-50
              border
              border-emerald-100
              rounded-2xl
              py-3
              pl-11
              pr-4
              text-sm
              text-zinc-700
              placeholder:text-zinc-400
              focus:border-emerald-400
              transition
            "
          />
        </div>

        {/* NOTIFICATIONS */}
        <button
          className="
            relative
            w-12
            h-12
            rounded-2xl
            bg-emerald-50
            border
            border-emerald-100
            flex
            items-center
            justify-center
            hover:bg-emerald-100
            transition
          "
        >
          <Bell
            size={20}
            className="text-emerald-600"
          />

          <span className="absolute top-2 right-2 w-2.5 h-2.5 bg-red-500 rounded-full" />
        </button>

        {/* SETTINGS */}
        <button
          className="
            w-12
            h-12
            rounded-2xl
            bg-emerald-50
            border
            border-emerald-100
            flex
            items-center
            justify-center
            hover:bg-emerald-100
            transition
          "
        >
          <Settings
            size={20}
            className="text-emerald-600"
          />
        </button>

        {/* USER */}
        <div className="flex items-center gap-3 bg-white border border-emerald-100 rounded-2xl px-4 py-2 shadow-sm">
          <div className="w-11 h-11 rounded-full bg-emerald-500 flex items-center justify-center text-white font-bold">
            DR
          </div>

          <div className="hidden lg:block">
            <p className="font-semibold text-zinc-800">
              Dr. Admin
            </p>

            <p className="text-sm text-zinc-500">
              Administrador
            </p>
          </div>
        </div>
      </div>
    </header>
  )
}