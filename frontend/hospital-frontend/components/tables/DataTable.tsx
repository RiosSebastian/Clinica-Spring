'use client'

interface Column {
  key: string
  label: string
}

interface DataTableProps {
  columns: Column[]
  data: any[]
}

export default function DataTable({
  columns,
  data,
}: DataTableProps) {
  return (
    <div className="bg-white border border-emerald-100 rounded-3xl overflow-hidden shadow-sm">
      <div className="overflow-x-auto">
        <table className="w-full border-collapse">
          <thead className="bg-emerald-50">
            <tr>
              {columns.map((column) => (
                <th
                  key={column.key}
                  className="text-left px-6 py-4 text-sm font-semibold text-emerald-700 uppercase tracking-wide"
                >
                  {column.label}
                </th>
              ))}
            </tr>
          </thead>

          <tbody>
            {data.length > 0 ? (
              data.map((row, index) => (
                <tr
                  key={index}
                  className="border-t border-emerald-50 hover:bg-emerald-50/40 transition"
                >
                  {columns.map((column) => (
                    <td
                      key={column.key}
                      className="px-6 py-5 text-zinc-700 font-medium"
                    >
                      {row[column.key]}
                    </td>
                  ))}
                </tr>
              ))
            ) : (
              <tr>
                <td
                  colSpan={columns.length}
                  className="text-center py-12 text-zinc-400 font-medium"
                >
                  No hay datos disponibles
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  )
}